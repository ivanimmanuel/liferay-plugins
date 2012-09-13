/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.akismet.hook.listeners;

import com.liferay.akismet.service.AkismetDataLocalServiceUtil;
import com.liferay.portal.ModelListenerException;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.messageboards.model.MBMessage;

/**
 * @author Amos Fong
 */
public class MBMessageListener extends BaseModelListener<MBMessage> {

	public void onAfterRemove(MBMessage message) throws ModelListenerException {
		try {
			AkismetDataLocalServiceUtil.deleteMessageAkismetData(
				message.getMessageId());
		}
		catch (Exception e) {
		}
	}

}