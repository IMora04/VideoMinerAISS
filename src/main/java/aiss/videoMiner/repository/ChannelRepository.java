package aiss.videoMiner.repository;

import aiss.videoMiner.model.Channel;
import aiss.videoMiner.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ChannelRepository extends JpaRepository<Channel, String> {



}
