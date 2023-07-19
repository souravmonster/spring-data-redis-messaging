package com.sourav;

import com.sourav.dto.Account;
import com.sourav.dto.Payment;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    @Autowired
    private RedisTemplate template;

    @Autowired
    private ChannelTopic topic;

    public String publish(Payment payment) {
        template.convertAndSend(topic.getTopic(), payment.toString());
        String resultMessage = "";
        if (StringUtils.isNotBlank(payment.getType())
                && !payment.getType().equalsIgnoreCase("null")) {
            switch (Account.PaymentType.getEnumByName(payment.getType())) {
                case DONE -> {
                    resultMessage = "Payment has been done";
                    break;
                }
                case PENDING -> {
                    resultMessage = "Payment is pending";
                    break;
                }
                case PROCESSED -> {
                    resultMessage = "Payment has been processed";
                    break;
                }
                case FAILED -> {
                    resultMessage = "Payment has been failed";
                    break;
                }
            }
        }
        return resultMessage;
    }
}
