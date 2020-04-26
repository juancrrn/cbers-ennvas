package com.cbers.ennvas.recommender.rest.controller.data;

import java.util.LinkedList;

import com.cbers.ennvas.recommender.domain.ResultValue;

public class RcmResponseWrapper
{

	private LinkedList<ResultValue> resultValues;

	public RcmResponseWrapper(LinkedList<ResultValue> resultValues)
	{
		this.resultValues = resultValues;
	}

	public LinkedList<ResultValue> getResultValues()
	{
		return this.resultValues;
	}

}