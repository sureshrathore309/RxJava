package com.apisero.rxjava.operators.filtering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class MapOperator {
	private static final Logger LOGGER = LoggerFactory.getLogger(MapOperator.class);
	public static void main (String []args) {
		LOGGER.info("map operator");
		Observable.fromIterable(RxUtils.postiveNumbers(10))
		.map(num -> num*2)
		.subscribe(new DemoObserver<Integer>());
	}

}
