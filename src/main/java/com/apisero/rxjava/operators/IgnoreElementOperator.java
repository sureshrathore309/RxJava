package com.apisero.rxjava.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class IgnoreElementOperator {
	private static final Logger LOGGER = LoggerFactory.getLogger(IgnoreElementOperator.class);
	public static void main (String []args) {
		LOGGER.info("ignoreElements operator");
		Observable.fromIterable(RxUtils.postiveNumbers(10))
		.ignoreElements().subscribe(new CompletableObserver() {
			@Override
			public void onSubscribe(Disposable d) {
				LOGGER.info("onSubscribe");
			}

			@Override
			public void onComplete() {
				LOGGER.info("onComplete");
			}

			@Override
			public void onError(Throwable e) {
				LOGGER.error("error ", e);				
			}			
		});		
	}
}
