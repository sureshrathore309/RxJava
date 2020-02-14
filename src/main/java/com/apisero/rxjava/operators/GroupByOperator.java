package com.apisero.rxjava.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.models.Shape;
import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableGroupBy.GroupByObserver;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;

public class GroupByOperator {
	private static final Logger LOGGER = LoggerFactory.getLogger(GroupByOperator.class);

	public static void main(String[] args) {
		Observable.fromIterable(RxUtils.shapes(20))
		.groupBy(new Function<Shape, Object>() {
			@Override
			public Object apply(Shape shape) throws Exception {
				return shape.getShape();
			}
		})
		.observeOn(Schedulers.newThread())
		.subscribe(new Observer<GroupedObservable<Object, Shape>>() {
			@Override
			public void onSubscribe(Disposable d) {
				LOGGER.info("onSubscribe");
			}

			@Override
			public void onNext(GroupedObservable<Object, Shape> shapeObservable) {
				LOGGER.info("key {}", shapeObservable.getKey());
				shapeObservable.subscribe(new DemoObserver());
			}

			@Override
			public void onError(Throwable e) {
				LOGGER.info("onError");								
			}

			@Override
			public void onComplete() {
				LOGGER.info("onComplete");												
			}			
		});
		RxUtils.sleep(3000);
	}
}
