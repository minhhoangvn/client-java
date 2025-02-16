/*
 * Copyright 2019 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.reportportal.annotations.attribute;

import java.lang.annotation.*;

/**
 * Annotation for test methods and classes to attach {@link com.epam.ta.reportportal.ws.model.attribute.ItemAttributesRQ} to the test items
 *
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 * @see Attribute
 * @see AttributeValue
 * @see MultiKeyAttribute
 * @see MultiValueAttribute
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
public @interface Attributes {

	Attribute[] attributes() default {};

	AttributeValue[] attributeValues() default {};

	MultiKeyAttribute[] multiKeyAttributes() default {};

	MultiValueAttribute[] multiValueAttributes() default {};
}
