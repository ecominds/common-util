/**
 * @author	: Rajiv Kumar
 * @project	: common-util
 * @since	: 0.0.1
 * @date	: 07-Jan-2023
 */
package com.github.ecominds.util.core;

import java.io.Serializable;
import java.util.Objects;

public class KeyValPair<K, V> implements Serializable{
	private static final long serialVersionUID = 1L;

	private K key;
	private V value;
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	@Override
	public String toString(){
		return "{" + key + ", " + value + "}";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(key);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		KeyValPair other = (KeyValPair) obj;
		return Objects.equals(key, other.key);
	}
}