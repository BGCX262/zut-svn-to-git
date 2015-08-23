package fr.dorian.web.impl;

import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.dorian.business.ThreadBO;
import fr.dorian.model.Thread;
import fr.dorian.service.exception.ServiceException;
import fr.dorian.web.ThreadListBean;

@Controller("threadListBean")
@Scope("session")
public class ThreadListBeanImpl implements ThreadListBean, Serializable {
	
	private static final long serialVersionUID = -7921983371844463571L;

	private static final Logger logger = Logger.getLogger(ThreadListBean.class);

	@Autowired(required = true)
	private ThreadBO threadBO;
		
	@Override
	public List<Thread> getAllThreads() {
		logger.debug("get all threads");
		List<Thread> threads = null;
		try {
			threads = this.threadBO.findAll();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return (threads);
	}
}
