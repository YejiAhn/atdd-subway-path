package wooteco.subway.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wooteco.subway.admin.domain.PathSearchType;
import wooteco.subway.admin.dto.ShortestPathResponse;
import wooteco.subway.admin.service.PathService;

@RestController
@RequestMapping("/paths")
public class PathController {
	private final PathService pathService;

	public PathController(PathService pathService) {
		this.pathService = pathService;
	}

	@GetMapping
	ResponseEntity<ShortestPathResponse> getShortestPath(@RequestParam String source, @RequestParam String target,
		@RequestParam(required = false, defaultValue = "distance") String type) {
		return ResponseEntity.ok(pathService.getShortestPath(source, target, PathSearchType.of(type)));
	}
}
