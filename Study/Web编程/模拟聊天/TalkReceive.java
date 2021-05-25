package com.pentacle.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
    DatagramSocket socket = null;
    private int port;
    private String MsgFrom; //接收方

    public TalkReceive(int port, String MsgFrom) {
        this.port = port;
        this.MsgFrom = MsgFrom;
        try {
            //开启连接
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                //准备接收包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);//阻塞式接收包裹
                //断开连接,bye
                byte[] data = packet.getData();
                String receiveData = new String(data, 0, data.length);
                System.out.println(MsgFrom + receiveData);
                if (receiveData.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        socket.close();
    }
}
