package com.kwit.action;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.kwit.model.RecordMemberRecharge;
import com.kwit.service.RecordMemberRechargeService;

import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class RecordMemberRechargeAction extends BaseAction<RecordMemberRecharge>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	protected RecordMemberRechargeService recordMemberRechargeService;
	
	private JSONObject result;
	
	private int memberId;
	
	/*
	 * 获取会员充值信息
	 */
	public String getRecordMemberRecharge(){
		jsonList = recordMemberRechargeService.getRecordMemberRecharge(model.getSocialCreditCode());
		return "jsonList";
	}

	/*
	 * 新增会员充值信息
	 */
	public String addRecordMemberRecharge(){
		Map<String, String> map=new HashMap<String, String>();
		map = recordMemberRechargeService.addRecordMemberRecharge(model,memberId);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}

	/*
	 * 修改会员
	 */
	public String updateRecordMemberRecharge(RecordMemberRecharge model){
		Map<String, String> map=new HashMap<String, String>();
		map = recordMemberRechargeService.updateRecordMemberRecharge(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}
	
	/*
	 * 删除会员
	 */
	public String deleteRecordMemberRecharge(RecordMemberRecharge model){
		Map<String, String> map=new HashMap<String, String>();
		map = recordMemberRechargeService.deleteRecordMemberRecharge(model);
		result=JSONObject.fromObject(map);
		return SUCCESS;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
}
