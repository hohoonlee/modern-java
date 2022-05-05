package ch11;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.concurrent.Flow;

public class FirstProcessor<T, R> extends SubmissionPublisher<R> implements Flow.Processor<T,R> {
	private Function<T,R> function;
	private Flow.Subscription subscription;

	public FirstProcessor(Function<T,R> function) {
		this.function = function;
	}

	@Override
	public void onSubscribe(Flow.Subscription subscription) {
		this.subscription = subscription;
	//	subscription.request(1);
	}

	@Override
	public void onNext(T item) {
		submit(function.apply(item));
		subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void onComplete() {
		close();
	}

	public static void main(String[] args) throws Exception {
		FirstPublisher<String> publisher = new FirstPublisher<>();
		FirstProcessor<String, String> processor = new FirstProcessor<>(name -> name + "값을 변환");

		FirstSubscriber<String> subscriber1 = new FirstSubscriber<>("Sub 1", 3);
		FirstSubscriber<String> subscriber2 = new FirstSubscriber<>("Sub 2", 5);

		publisher.subscribe(processor);
		//processor.subscribe(subscriber1);
		//processor.subscribe(subscriber2);

		TimeUnit.SECONDS.sleep(10);
	}

}
