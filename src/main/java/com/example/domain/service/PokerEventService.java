package com.example.domain.service;

import com.example.domain.model.EventMember;
import com.example.domain.model.Host;
import com.example.domain.model.PokerEvent;
import com.example.domain.model.ProductBacklogItemSender;
import com.example.infra.HostRepository;
import com.example.infra.PokerEventRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokerEventService {

  private final PokerEventRepository pokerEventRepository;
  private final ProductBacklogItemSender sender;
  private final HostRepository hostRepository;

  @Autowired
  public PokerEventService(
      PokerEventRepository pokerEventRepository,
      ProductBacklogItemSender sender,
      HostRepository hostRepository) {
    this.pokerEventRepository = pokerEventRepository;
    this.sender = sender;
    this.hostRepository = hostRepository;
  }

  /**
   * 新しいポーカーイベントを作成します。 アカウントIDからイベントホストを生成します。 またイベント参加者をDBに登録します。
   *
   * @param eventMember イベント参加者
   * @param accountId イベントホストのアカウントID
   * @return ホスト
   */
  public Host create(EventMember eventMember, String accountId) {
    // todo : PokerEventのdomainにホストを作成する仕様を含めるべき？
    PokerEvent.of().create(eventMember, sender);
    pokerEventRepository.registerMember(eventMember);

    Host host = new Host(accountId);
    hostRepository.register(host);
    return host;
  }

  public List<EventMember> fetchEventMember() {
    return pokerEventRepository.fetch();
  }
}
