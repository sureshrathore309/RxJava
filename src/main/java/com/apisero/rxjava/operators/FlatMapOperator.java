package com.apisero.rxjava.operators;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class FlatMapOperator {
	private static final Logger LOGGER = LoggerFactory.getLogger(FlatMapOperator.class);

	public static void main(String[] args) {
		LOGGER.info("flatmap operator");
		List<Integer> positiveIntegers = RxUtils.postiveNumbers(10);
		Observable.fromIterable(positiveIntegers)
		.flatMap(num -> twice(num))
		.subscribe(new DemoObserver<Integer>());		
	}
	
	public static Observable<Integer> twice(Integer integer){
		return Observable.create(observableEmitter ->{
			if (!observableEmitter.isDisposed())
				observableEmitter.onNext(integer *2);
			else
				observableEmitter.onComplete();
		});
	}
}