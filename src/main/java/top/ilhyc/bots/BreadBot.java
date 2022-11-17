package top.ilhyc.bots;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.BotInvitedJoinGroupRequestEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;

import java.util.ArrayList;
import java.util.List;


/**
 * 使用 Java 请把
 * {@code /src/main/resources/META-INF.services/net.mamoe.mirai.console.plugin.jvm.JvmPlugin}
 * 文件内容改成 {@code org.example.mirai.plugin.JavaPluginMain} <br/>
 * 也就是当前主类全类名
 *
 * 使用 Java 可以把 kotlin 源集删除且不会对项目有影响
 *
 * 在 {@code settings.gradle.kts} 里改构建的插件名称、依赖库和插件版本
 *
 * 在该示例下的 {@link JvmPluginDescription} 修改插件名称，id 和版本等
 *
 * 可以使用 {@code src/test/kotlin/RunMirai.kt} 在 IDE 里直接调试，
 * 不用复制到 mirai-console-loader 或其他启动器中调试
 */

public final class BreadBot extends JavaPlugin {
    public static final BreadBot INSTANCE = new BreadBot();
    public static List<Long> passgroup = new ArrayList<>();

    private BreadBot() {
        super(new JvmPluginDescriptionBuilder("top.ilhyc", "0.1.0")
                .name("BreadBot")
                .author("qq为1853699150")
                .info("start!")
                .build());
        passgroup.add(Long.parseLong("9978657054"));
    }

    @Override
    public void onEnable() {
        EventChannel<Event> eventChannel = GlobalEventChannel.INSTANCE.parentScope(this);
        eventChannel.subscribeAlways(GroupMessageEvent.class, g -> {
            //监听群消息
            if(passgroup.contains(g.getGroup().getId())){
            }
        });
        eventChannel.subscribeAlways(BotInvitedJoinGroupRequestEvent.class, a->{
            if(a.getInvitor().getId()==1853699150){  //短期辅助功能:)
                a.accept();
            }
        });
    }
}
