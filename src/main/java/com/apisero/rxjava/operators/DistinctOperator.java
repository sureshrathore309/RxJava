package com.apisero.rxjava.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;

import io.reactivex.Observable;

public class DistinctOperator {
	private static final Logger LOGGER = LoggerFactory.getLogger(DistinctOperator.class);
	public static void main (String []args) {
		LOGGER.info("Distinct Operator");
		Observable.just(1,2,2,3,3,6,17,8,9,10)
		.distinct()
		.subscribe(new DemoObserver<Integer>());
	}
}
