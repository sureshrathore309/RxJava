package com.apisero.rxjava.operators;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;

public class FilterOperator {
	private static final Logger LOGGER = LoggerFactory.getLogger(FilterOperator.class);
	public static void main (String []args) {
		LOGGER.info("Filter Operator");
		List<Integer> number = RxUtils.postiveNumbers(10);
		number.forEach(n->System.out.print(n+" "));
		System.out.println();
		Observable.fromIterable(number).filter(n -> n>5).subscribe(new DemoObserver<Integer>());
	}
}
