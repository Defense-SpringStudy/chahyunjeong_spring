package hello.core.lifecycle;

import hello.core.discount.DiscountPolicy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {

    private String url;

    public NetworkClient(){
        System.out.println(url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void connect(){
        System.out.println(url);
    }

    public void call(String message){
        System.out.println(url+message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close"+url);
    }

    public void init() {
        connect();
        call("초기화 연결메세지");
    }


    public void close() {
        disconnect();
    }
}
