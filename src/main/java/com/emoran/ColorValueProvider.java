package com.emoran;

import java.util.Set;
import org.mule.runtime.api.value.Value;
import org.mule.runtime.extension.api.values.ValueBuilder;
import org.mule.runtime.extension.api.values.ValueProvider;
import org.mule.runtime.extension.api.values.ValueResolvingException;

public class ColorValueProvider  implements ValueProvider {
  @Override
  public Set<Value> resolve() throws ValueResolvingException {
    return ValueBuilder.getValuesFor("black_and_white", "black", "white","yellow","orange","red","purple","magenta","green","teal","blue");
  }
}
