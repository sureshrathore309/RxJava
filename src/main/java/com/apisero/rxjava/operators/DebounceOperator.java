package com.apisero.rxjava.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DebounceOperator {
	private static final Logger LOGGER = LoggerFactory.getLogger(DebounceOperator.class);
	private static List<Character> changeIt = new ArrayList<>();
	
	public static void main (String []args) {
		LOGGER.info("Debounce Operator");
		Random random = new Random();
		Observable.interval(2, TimeUnit.SECONDS)
		.map(c -> {
			changeIt.add((char) (random.nextInt(26) +'a'));
			return changeIt;
		}).doOnEach(notification -> {
			LOGGER.info("Current value -> {} ", notification);
		}).debounce(2, TimeUnit.SECONDS)
		.subscribeOn(Schedulers.newThread())
		.observeOn(Schedulers.newThread())
		.subscribe(new DemoObserver());
		RxUtils.sleep(10000);
	}
}
