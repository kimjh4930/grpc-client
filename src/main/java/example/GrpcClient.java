package example;

import example.HelloReply;
import example.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String args[]){

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999)
                .usePlaintext()
                .build();

        example.HelloServiceGrpc.HelloServiceBlockingStub stub = example.HelloServiceGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder().setFirstName("Junha").setLastName("Kim").build();
        HelloReply reply = stub.sayHello(request);

        System.out.println("Reply : " + reply.getGreeting());

        channel.shutdown();

    }
}
