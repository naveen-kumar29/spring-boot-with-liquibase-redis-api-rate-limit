package com.example.grpc;

import com.example.grpc.GreeterServiceGrpc;
import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
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

