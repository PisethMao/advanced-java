package org.example.allnewfeaturesinjava9.streamapi;

import org.example.allnewfeaturesinjava9.streamapi.service.StreamDemoService;

public class Main {
    static void main() {
        StreamDemoService service = new StreamDemoService();
        service.takeWhileExample();
        service.dropWhileExample();
        service.iterateExample();
        service.installmentExample();
        service.ofNullableExample();
        service.customerPhoneExample();
        service.filteringCollectorExample();
        service.flatMappingCollectorExample();
    }
}
