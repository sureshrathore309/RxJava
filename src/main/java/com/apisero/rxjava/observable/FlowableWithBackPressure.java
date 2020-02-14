package com.apisero.rxjava.observable;

import java.util.concurrent.atomic.AtomicInteger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class FlowableWithBackPressure {
	private static final Logger LOGGER = LoggerFactory.getLogger(FlowableWithBackPressure.class);

	public static void main(String[] args) {
		Flowable<Integer> flowablePositiveNumber = Flowable.fromIterable(RxUtils.postiveNumbers(1000000)).repeat()
				.observeOn(Schedulers.newThread(), false, 5).subscribeOn(Schedulers.newThread())
				.doOnNext(num -> LOGGER.info("Emitting Integer -> {}", num));
		flowablePositiveNumber.subscribe(new Subscriber<Integer>() {
			private Subscription subscription;
			private AtomicInteger counter = new AtomicInteger(0);

			@Override
			public void onSubscribe(Subscription s) {
				this.subscription = s;
				s.request(5);
				LOGGER.info("onSubscribe");
			}

			@Override
			public void onNext(Integer t) {
				LOGGER.info("onNext : " + t);
				RxUtils.sleep(100L);
				if (counter.incrementAndGet() % 5 == 0)
					subscription.request(5);
			}

			@Override
			public void onError(Throwable t) {
				LOGGER.error("onError : " + t.getMessage());
			}

			@Override
			public void onComplete() {
				LOGGER.info("onComplete");
			}
		});
		RxUtils.sleep(10000);
	}
}
