/*
* Copyright 2019 NexCloud Co.,Ltd.
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
package com.nexcloud.tsdb.adapter.manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nexcloud.tsdb.adapter.HostNetworkAdapter;
import com.nexcloud.tsdb.client.adapter.influx.HostNetworkInfluxAdapter;
import com.nexcloud.tsdb.client.adapter.prometheus.HostNetworkPrometheusAdapter;

@Component
public class HostNetworkAdapterManager {
	@Value("${tsdb}") private String DB;
	@Autowired private HostNetworkInfluxAdapter influxAdapter; 
	@Autowired private HostNetworkPrometheusAdapter prometheusAdapter;

	public HostNetworkAdapter adapter() {
		if (DB.equals("influx")) return influxAdapter;
		else if (DB.equals("prometheus")) return prometheusAdapter;
		else {
			System.out.println("err");
			return null;
		}
	}
}
