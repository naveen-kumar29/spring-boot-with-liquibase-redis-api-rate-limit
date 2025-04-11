package com.example.grpc;

import com.example.grpc.GreeterServiceGrpc;
import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GreeterClient {

    @GrpcClient("greeter-service")
    private GreeterServiceGrpc.GreeterServiceBlockingStub blockingStub;

    public String SayHello(String name) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();

        HelloResponse response = blockingStub.sayHello(request);
        return response.getMessage();
    }
}
