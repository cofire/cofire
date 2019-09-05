package com.cofire.common.result;

/**
 * 
 * @ClassName: paramItem
 * @Description:接受前台传过来的数据中公共请求参数
 * @date 2019年5月13日
 *
 * @param <T>
 */
public class ParamItem {
	//停车场页面传入的为50/100
	private Integer length1;
    // 当前页面
    private Integer page;
    // 页面大小
    private Integer length;
    // 标志 add 代表新增 mod 代表编辑
    private String flag;
    // 创建时间开始时间
    private String createTimeStr;
	// 创建时间结束时间
    private String createTimeEnd;
    // 用于创建时间组件传入的时间数组
    private String[] createTimes;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

    public String[] getCreateTimes() {
        return createTimes;
    }

    public void setCreateTimes(String[] createTimes) {
        this.createTimes = createTimes;
    }

	public Integer getLength1() {
		return length1;
	}

	public void setLength1(Integer length1) {
		this.length1 = length1;
	}
    
}
