package biz;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.util.PatternMatchUtils;

public class NameMatchClassMethodPointcut extends NameMatchMethodPointcut{
	public void setMappedClassName(String mappedClassName) {
		this.setClassFilter(new SimpleClassFilter(mappedClassName));
	}
	
	static class SimpleClassFilter implements ClassFilter {
		String mappedName;
		
		private SimpleClassFilter(String mappedName) {
			this.mappedName = mappedName;
		}
		
		public boolean matches(Class<?> clazz) {
			boolean result = PatternMatchUtils.simpleMatch(mappedName, clazz.getSimpleName());
			if(result)
				System.out.println("참 입니다. class :" + clazz.getSimpleName());
//			return PatternMatchUtils.simpleMatch(mappedName, clazz.getSimpleName());
			return result;
		}
	}
}
