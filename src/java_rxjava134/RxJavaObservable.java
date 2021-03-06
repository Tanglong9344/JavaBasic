package java_rxjava134;

import java.util.Iterator;
import java.util.List;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Observable in RxJava-1.3.4
 *
 * @author ����
 *
 */
public class RxJavaObservable {
	public static void main(String[] args) {
		// Iterator
		List<String> list = java_common.CommonUtils.getList(10);
		for(Iterator<String> i=list.iterator();i.hasNext();) {
			System.out.println(i.next());
		}
		System.out.println();

		// Observable
		hello(list);
		System.out.println("-----------------");
		helloErrorCompleted(list);
	}

	/** Observable's first use
	 *
	 * Observable and Observer,
	 * they communicate with each other through subscribing
	 * */
	public static void hello(List<String> list) {
		Observable.from(list).subscribe(new Action1<String>() {
			@Override
			public void call(String s) {
				System.out.println("Hello " + s);
			}
		});
	}

	/** Add methods to show error and completed messages */
	public static void helloErrorCompleted(List<String> list) {
		Observable.from(list).subscribe(
				new Action1<String>() {
					@Override
					public void call(String s) {
						System.out.println("Hello " + s);
					}
				}, new Action1<Throwable>() { // invoked when errors occur
					@Override
					public void call(Throwable t) {
						System.err.println("Something wrong: " + t);
					}
				}, new Action0() { // invoked when finished
					@Override
					public void call() {
						System.out.println("Finnished!");
					}
				});
	}

	/** implement of Observable's <method>from</method> */
	@SuppressWarnings({ "deprecation", "hiding" })
	public static <T> Observable<T> fromIterable(final Iterable<T> iterable) {
		return Observable.create(new OnSubscribe<T>() {
			@Override
			public void call(Subscriber<? super T> subscriber) {
				try {
					for(Iterator<T> i = iterable.iterator();i.hasNext();) {
						if(subscriber.isUnsubscribed()) { return; }
						subscriber.onNext(i.next());
					}
					if( !subscriber.isUnsubscribed()) {
						subscriber.onCompleted();
					}
				} catch (Exception e) {
					if(!subscriber.isUnsubscribed()) {
						subscriber.onError(e);
					}
				}
			}
		});
	}
}