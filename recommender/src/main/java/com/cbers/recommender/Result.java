package com.cbers.recommender;

public class Result
{
	private final long id;
	private final String content;

	/**
	 * Constructor.
	 * 
	 * @param id
	 * @param content
	 */
	public Result(long id, String content)
	{
		this.id = id;
		this.content = content;
	}

	public long getId()
	{
		return this.id;
	}

	public String getContent()
	{
		return this.content;
	}
}