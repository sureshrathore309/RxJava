package com.apisero.rxjava.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ElementAtOperator {
	private static final Logger LOGGER = LoggerFactory.getLogger(ElementAtOperator.class);
	public static void main (String []args) {
		LOGGER.info("ElementAt operator");
		Observable.fromIterable(RxUtils.postiveNumbers(10))
		.elementAt(11).subscribe(new MaybeObserver<Integer>() {
			@Override
			public void onSubscribe(Disposable d) {
				LOGGER.info("onSubscribe");
			}

			@Override
			public void onSuccess(Integer t) {
				LOGGER.info("onSuccess {} ",t);
			}

			@Override
			public void onError(Throwable e) {
				LOGGER.error("onError",e);
			}

			@Override
			public void onComplete() {
				LOGGER.info("onComplete");				
			}
		});
		
	}
}
