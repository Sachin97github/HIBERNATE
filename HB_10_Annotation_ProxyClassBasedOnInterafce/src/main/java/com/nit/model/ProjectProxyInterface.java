package com.nit.model;

import javax.persistence.Column;
import javax.persistence.Transient;

import com.sun.istack.NotNull;

public interface ProjectProxyInterface {

	public Long getProID();

	public String getTransientTest();

	public void setTransientTest(String transientTest);

	public void setProID(Long proID);

	public String getpName();

	public void setpName(String pName);

	public String getpCompony();

	public void setpCompony(String pCompony);

	public String getpDuration();

	public void setpDuration(String pDuration);

}
