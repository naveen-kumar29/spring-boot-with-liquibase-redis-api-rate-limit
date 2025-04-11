package com.example.liquibase.grpc;

import com.example.liquibase.grpc.GreeterServiceGrpc;
import com.example.liquibase.grpc.HelloRequest;
import com.example.liquibase.grpc.HelloResponse;
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
