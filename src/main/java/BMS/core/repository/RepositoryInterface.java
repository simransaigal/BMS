package BMS.core.repository;

import java.util.List;

public interface RepositoryInterface<Entity> {
     List<Entity> get() ;
     Entity add(Entity e);
     Entity update(Entity e);
     Entity delete(Entity e);
}
