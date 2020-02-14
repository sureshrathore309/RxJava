package com.apisero.rxjava.operators;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class ScanOperator {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScanOperator.class);
	public static void main (String []args) {
		LOGGER.info("Scan Operator");
		List<Integer> numbers = RxUtils.postiveNumbers(10);
		Observable.fromIterable(numbers)
		.scan((num1, num2) -> num1+num2).subscribe(new DemoObserver<Integer>());
	}
}
