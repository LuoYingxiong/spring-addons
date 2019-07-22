/*
 * Copyright 2019 Jérôme Wacongne.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.c4_soft.springaddons.security.test.web.reactive.server;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import com.c4_soft.springaddons.security.test.support.Defaults;
import com.c4_soft.springaddons.security.test.support.jwt.JwtAuthenticationTokenUnitTestsParent;
import com.c4_soft.springaddons.security.test.support.jwt.JwtAuthenticationTokenWebTestClientConfigurer;

/**
 * @author Jérôme Wacongne &lt;ch4mp&#64;c4-soft.com&gt;
 */
public class JwtAuthenticationTokenConfigurerTests extends JwtAuthenticationTokenUnitTestsParent {

	private JwtAuthenticationTokenWebTestClientConfigurer mockCh4mpy() {
		return securityWebTestClientConfigurer().name("ch4mpy").authorities("message:read");
	}

// @formatter:off
	@Test
	public void testDefaultJwtConfigurer() {
		TestController.clientBuilder()
				.apply(securityWebTestClientConfigurer()).build()
				.get().uri("/authentication").exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo(String.format(
						"Authenticated as %s granted with %s. Authentication type is %s.",
						Defaults.AUTH_NAME,
						Arrays.asList(Defaults.AUTHORITIES),
						JwtAuthenticationToken.class.getName()));
	}

	@Test
	public void testCustomJwtConfigurer() {
		TestController.clientBuilder()
				.apply(mockCh4mpy()).build()
				.get().uri("/authentication").exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo(String.format(
						"Authenticated as %s granted with %s. Authentication type is %s.",
						"ch4mpy",
						"[message:read]",
						JwtAuthenticationToken.class.getName()));

		TestController.clientBuilder()
				.apply(mockCh4mpy())
				.build()
				.get().uri("/jwt").exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo(
						"You are successfully authenticated and granted with {sub=ch4mpy} claims using a JSON Web Token.");
	}

	@Test
	public void testCustomJwtMutator() {
		TestController.client()
				.mutateWith(mockCh4mpy())
				.get().uri("/authentication").exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo(String.format(
						"Authenticated as %s granted with %s. Authentication type is %s.",
						"ch4mpy",
						"[message:read]",
						JwtAuthenticationToken.class.getName()));

		TestController.client()
				.mutateWith(mockCh4mpy())
				.get().uri("/jwt").exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo(
						"You are successfully authenticated and granted with {sub=ch4mpy} claims using a JSON Web Token.");
	}
// @formatter:on
}