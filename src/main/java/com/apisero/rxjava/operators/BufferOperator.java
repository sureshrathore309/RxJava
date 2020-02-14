package com.apisero.rxjava.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class BufferOperator {
	private static final Logger LOGGER = LoggerFactory.getLogger(BufferOperator.class);

	public static void main(String[] args) {
		Observable.fromIterable(RxUtils.shapes(10))
		.buffer(10)
		.subscribe(new DemoObserver());
	}
}
