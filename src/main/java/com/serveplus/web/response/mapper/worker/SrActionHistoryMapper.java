package com.serveplus.web.response.mapper.worker;

import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.web.response.SrActionHistoryVO;
import com.serveplus.web.response.mapper.Mapper;

public class SrActionHistoryMapper implements Mapper<SrActionHistory,SrActionHistoryVO>{

	@Override
	public SrActionHistoryVO mapFrom(SrActionHistory source) {
		SrActionHistoryVO actionHistoryVO = new SrActionHistoryVO();
		actionHistoryVO.setAction(source.getAction());
		actionHistoryVO.setTime(source.getCreatedDate());
		return actionHistoryVO;
	}

}
