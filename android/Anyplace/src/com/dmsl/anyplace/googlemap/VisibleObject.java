/*
* AnyPlace: A free and open Indoor Navigation Service with superb accuracy!
*
* Anyplace is a first-of-a-kind indoor information service offering GPS-less
* localization, navigation and search inside buildings using ordinary smartphones.
*
* Author(s): Timotheos Constambeys
* 
* Supervisor: Demetrios Zeinalipour-Yazti
*
* URL: http://anyplace.cs.ucy.ac.cy
* Contact: anyplace@cs.ucy.ac.cy
*
* Copyright (c) 2015, Data Management Systems Lab (DMSL), University of Cyprus.
* All rights reserved.
*
* Permission is hereby granted, free of charge, to any person obtaining a copy of
* this software and associated documentation files (the "Software"), to deal in the
* Software without restriction, including without limitation the rights to use, copy,
* modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
* and to permit persons to whom the Software is furnished to do so, subject to the
* following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
* OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
* DEALINGS IN THE SOFTWARE.
*
*/

package com.dmsl.anyplace.googlemap;

import java.util.HashMap;

import com.google.android.gms.maps.model.Marker;

public class VisibleObject<T> {

	// association between markers on screen and their PoisModels with the POI
	// information
	HashMap<Marker, T> mMarkersToPoi = null;
	HashMap<com.amap.api.maps.model.Marker, T> mMarkersToPoi2 = null;

	public VisibleObject() {
		mMarkersToPoi = new HashMap<Marker, T>();
		mMarkersToPoi2 = new HashMap<com.amap.api.maps.model.Marker, T>();
	}

	public void hideAll() {
		for (Marker m : mMarkersToPoi.keySet()) {
			m.setVisible(false);
		}
		for (com.amap.api.maps.model.Marker m : mMarkersToPoi2.keySet()) {
			m.setVisible(false);
		}
	}

	public void showAll() {
		for (Marker m : mMarkersToPoi.keySet()) {
			m.setVisible(true);
		}
		for (com.amap.api.maps.model.Marker m : mMarkersToPoi2.keySet()) {
			m.setVisible(true);
		}
	}

	public void clearAll() {
		for (Marker m : mMarkersToPoi.keySet()) {
			m.remove();
		}
		mMarkersToPoi.clear();
		for (com.amap.api.maps.model.Marker m : mMarkersToPoi2.keySet()) {
			m.remove();
		}
		mMarkersToPoi2.clear();
	}

	public T getPoisModelFromMarker(Marker m) {
		return mMarkersToPoi.get(m);
	}

	public T getPoisModelFromMarker(com.amap.api.maps.model.Marker m) {
		return mMarkersToPoi2.get(m);
	}

	public void addMarkerAndPoi(Marker m, T pm) {
		mMarkersToPoi.put(m, pm);
	}

	public void addMarkerAndPoi(com.amap.api.maps.model.Marker m, T pm) {
		mMarkersToPoi2.put(m, pm);
	}

}
