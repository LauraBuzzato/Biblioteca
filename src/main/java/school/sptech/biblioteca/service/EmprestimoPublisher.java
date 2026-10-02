package school.sptech.biblioteca.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import school.sptech.biblioteca.config.RabbitConfig;
import school.sptech.biblioteca.dto.EmprestimoMensagem;

@Service
public class EmprestimoPublisher {

    private final RabbitTemplate rabbitTemplate;

    public EmprestimoPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviar(EmprestimoMensagem mensagem) {

        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_NAME,
                RabbitConfig.ROUTING_KEY_NAME,
                mensagem
        );
    }
}