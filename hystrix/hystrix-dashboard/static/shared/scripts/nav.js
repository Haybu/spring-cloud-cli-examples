/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

'use strict';

var navModule = angular.module('nav', []);

navModule.controller('NavController', function ($rootScope, $scope, $location) {
    $scope.activateItem = function (item) {
        $location.path(item.path);
    };

    function initNav() {
        var currentPath = $location.path();
        if (currentPath.length === 0) {
            // $location.path() is empty, default to first item
            $scope.navItems[0].active = true;
        } else {
            $scope.navItems.forEach(function (item) {
                item.active = (item.path == currentPath);
            });
        }
    }

    $rootScope.$on('$locationChangeSuccess', function () {
        initNav();
    });

    initNav();
});