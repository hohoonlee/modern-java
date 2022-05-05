package ch11;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;

public class FirstPublisher<T> implements Flow.Publisher<String> {

	@Override
	public void subscribe(Subscriber<? super String> subscriber) {
		subscriber.onSubscribe(new MySubscription(subscriber));
	}

	public static void main(String[] args) {
		FirstPublisher<String> publisher = new FirstPublisher<>();
		publisher.subscribe(new FirstSubscriber<String>("Subscriver 1", 5));
		publisher.subscribe(new FirstSubscriber<String>("Subscriver 2", 5));
	}
}

class MySubscription implements Flow.Subscription {
	private Subscriber<? super String> subscriber;

	public MySubscription(Subscriber<? super String> subscriber) {
		this.subscriber = subscriber;
	}

	@Override
	public void request(long n) {
		publishItems(n);
	}

	@Override
	public void cancel() {
		System.out.println("Canceled");
	}

	private void publishItems(long n) {
		for(int i = 0; i < n; i++) {
			subscriber.onNext("Hellow Subscriver!! " + n);
		}
	}
}