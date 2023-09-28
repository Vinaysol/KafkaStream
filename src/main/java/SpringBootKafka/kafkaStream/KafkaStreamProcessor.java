package SpringBootKafka.kafkaStream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class KafkaStreamProcessor {

    @Autowired
    StreamsBuilder streamsBuilder;

    @PostConstruct
    public void processStram() {
        KStream<String, String> kStream = streamsBuilder.stream("v-stream-input", Consumed.with(Serdes.String(), Serdes.String()));
        kStream.peek((k, v) -> System.out.println("value: " + v))
                .mapValues((k, v) -> v.toUpperCase())
                .to("v-stream-output", Produced.with(Serdes.String(), Serdes.String()));
    }
}
