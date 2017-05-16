package online.edu.servive.impl;

import online.edu.mapper.MessageMapper;
import online.edu.servive.MessageService;
import online.edu.entity.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MessageServiceImpl extends InitServiceImpl<MessageMapper,Message> implements MessageService {
}
