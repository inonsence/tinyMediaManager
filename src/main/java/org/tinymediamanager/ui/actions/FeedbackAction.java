/*
 * Copyright 2012 - 2018 Manuel Laggner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tinymediamanager.ui.actions;

import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tinymediamanager.core.Message;
import org.tinymediamanager.core.Message.MessageLevel;
import org.tinymediamanager.core.MessageManager;
import org.tinymediamanager.ui.IconManager;
import org.tinymediamanager.ui.TmmUIHelper;
import org.tinymediamanager.ui.UTF8Control;

/**
 * The FeedbackAction to call the forums for a feedback
 * 
 * @author Manuel Laggner
 */
public class FeedbackAction extends AbstractAction {
  private static final long           serialVersionUID = 6615485711570687445L;
  private static final ResourceBundle BUNDLE           = ResourceBundle.getBundle("messages", new UTF8Control()); //$NON-NLS-1$
  private static final Logger         LOGGER           = LoggerFactory.getLogger(FeedbackAction.class);

  public FeedbackAction() {
    putValue(NAME, BUNDLE.getString("Feedback")); //$NON-NLS-1$
    putValue(SHORT_DESCRIPTION, BUNDLE.getString("Feedback")); //$NON-NLS-1$
    putValue(SMALL_ICON, IconManager.FEEDBACK);
    putValue(LARGE_ICON_KEY, IconManager.FEEDBACK);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String url = StringEscapeUtils.unescapeHtml4("http://forum.kodi.tv/forumdisplay.php?fid=204");
    try {
      TmmUIHelper.browseUrl(url);
    }
    catch (Exception e1) {
      LOGGER.error("FAQ", e1);
      MessageManager.instance
          .pushMessage(new Message(MessageLevel.ERROR, url, "message.erroropenurl", new String[] { ":", e1.getLocalizedMessage() }));
    }
  }
}
