package ch11;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicInteger;

public class FirstSubscriber<T> implements Flow.Subscriber<T> {
	private AtomicInteger maxNumber;
	private String subscriberName;
	private Subscription subscription;

	public FirstSubscriber(String subscriberName, int maxRequest) {
		this.maxNumber = new AtomicInteger(maxRequest);
		this.subscriberName = subscriberName;
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(T item) {
		System.out.println(subscriberName + ", 수신 항목 : " + item);

		maxNumber.decrementAndGet();
		if(maxNumber.get() > -1) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			subscription.request(1);
		}

	}

	@Override
	public void onError(Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println(subscriberName + ", 완료");
		subscription.cancel();
	}
}