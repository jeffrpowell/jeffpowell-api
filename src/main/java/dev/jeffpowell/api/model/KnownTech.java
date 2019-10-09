package dev.jeffpowell.api.model;

import java.util.Objects;

public class KnownTech {
	private String name;
	private String category;

	public KnownTech()
	{
	}

	public KnownTech(String name, String category)
	{
		this.name = name;
		this.category = category;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 71 * hash + Objects.hashCode(this.name);
		hash = 71 * hash + Objects.hashCode(this.category);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final KnownTech other = (KnownTech) obj;
		if (!Objects.equals(this.name, other.name))
		{
			return false;
		}
		return Objects.equals(this.category, other.category);
	}
}
