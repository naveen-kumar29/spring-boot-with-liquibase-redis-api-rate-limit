package com.example.liquibase.grpc;

import com.example.liquibase.grpc.GreeterServiceGrpc;
import com.example.liquibase.grpc.HelloRequest;
import com.example.liquibase.grpc.HelloResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreeterServiceImpl extends GreeterServiceGrpc.GreeterServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        String name = request.getName();
        String message = "Hello, " + name + "!";

        HelloResponse response = HelloResponse.newBuilder()
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

