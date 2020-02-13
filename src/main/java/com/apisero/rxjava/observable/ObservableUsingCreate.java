package com.apisero.rxjava.observable;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apisero.rxjava.models.Shape;
import com.apisero.rxjava.observer.DemoObserver;
import com.apisero.rxjava.utils.RxUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


public class ObservableUsingCreate {
	private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingCreate.class);
	public static void main (String []args) {
		List<Shape> shape = RxUtils.shapes(15);
		Observable.create(new ObservableOnSubscribe<Object>() {
			public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
				try {
					shape.forEach(emitter::onNext);
				}
				catch (Exception e) {
					emitter.onError(e);
				}
				emitter.onComplete();
			}			
		}).subscribe(new DemoObserver<Object>());
		
	}

}