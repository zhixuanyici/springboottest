package hello.test.entity;

import java.io.Serializable;

public class Product implements Serializable {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Integer productId;

    private String productName;

    private Integer productType;

    private String createUser;
    
    

    public Product() {
		super();
	}

	public Product(String productName, Integer productType, String createUser) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.createUser = createUser;
	}
	

	public Product(Integer productId, String productName, Integer productType, String createUser) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.createUser = createUser;
	}

	public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }
}