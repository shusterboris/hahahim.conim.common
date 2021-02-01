package proxies;

import java.io.Serializable;

public class Store extends Address implements Serializable {
	private static final long serialVersionUID = 2624926622636823053L;
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	protected String name;

	protected Long headQuatersId = (long) 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Long getHeadQuatersId() {
		return headQuatersId;
	}

	public void setHeadQuatersId(Long headQuatersId) {
		this.headQuatersId = headQuatersId;
	}


	public Store(Long id, String name, Long headQuatersId) {
		this.id = id;
		this.name = name;
		this.headQuatersId = headQuatersId;
	}

	public String toStringShort() {
		if (!"".equals(name))
			return name.concat(". ").concat(getSettlement());
		else
			return getSettlement().concat(",").concat(getStreetAddress());
	}
	
	public String toString() {
		if (!"".equals(name))
			return name.concat(". ").concat(getSettlement()).concat(",").concat(getStreetAddress());
		else
			return getSettlement().concat(",").concat(getStreetAddress());
		
	}
}
